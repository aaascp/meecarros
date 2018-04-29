package controllers.annotations.paged;

import data.Repository;
import play.inject.Injector;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public class PagedActionAnnotation extends Action<Paged> {

    public static final String LINK_HEADER_HELPER_TAG = "LINK_HEADER_HELPER_TAG";

    @Inject
    private Injector injector;

    @Override
    public CompletionStage<Result> call(Http.Context ctx) {
        Optional<Repository> repository = extractRepository();
        if (!repository.isPresent()) {
            return delegate.call(ctx);
        }

        LinkHeaderHelper linkHeaderHelper =
                LinkHeaderHelper.linkHeaderHelperFactory(
                        ctx.request(),
                        repository.get());

        ctx.args.put(LINK_HEADER_HELPER_TAG, linkHeaderHelper);

        linkHeaderHelper.getLinkHeader()
                .ifPresent(value ->
                        ctx.response().setHeader("Link", value));

        ctx.response().setHeader(
                        "X-Total-Count",
                        String.valueOf(repository.get().size()));

        return delegate.call(ctx);
    }

    private Optional<Repository> extractRepository() {
        try {
            Repository repository = injector.instanceOf(configuration.value());
            return Optional.of(repository);
        } catch (Exception exception) {
            //Silently failing
            // TODO Log on logging tool
            exception.printStackTrace();
            return Optional.empty();
        }
    }
}
