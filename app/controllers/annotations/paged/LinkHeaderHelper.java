package controllers.annotations.paged;

import data.Repository;
import data.dao.cars.CarsDao;
import models.ModelEntity;
import play.mvc.Http;
import utils.StringUtils;

import java.util.List;
import java.util.Optional;

public class LinkHeaderHelper {

    private static final String OFFSET_TAG = "offset";
    private static final String LIMIT_TAG = "limit";

    private static final String NEXT_REL = "next";

    private static final int DEFAULT_LIMIT = 5;

    private boolean isSecure;
    private String host;
    private String path;
    private long nextOffset;
    private long offset;
    private int limit;

    private LinkHeaderHelper(
            boolean isSecure,
            String host,
            String path,
            long nextOffset,
            long offset,
            int limit) {

        this.isSecure = isSecure;
        this.host = host;
        this.path = path;
        this.nextOffset = nextOffset;
        this.offset = offset;
        this.limit = limit;
    }

    public long getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    Optional<String> getLinkHeader() {
        if (nextOffset == 0) {
            return Optional.empty();
        } else {
            String link =
                    String.format(
                            "<http%s://%s%s?offset=%d&limit=%d>; rel=\"%s\"",
                            isSecure ? "s" : "",
                            host,
                            path,
                            nextOffset,
                            limit,
                            NEXT_REL);
            return Optional.of(link);
        }
    }

    static LinkHeaderHelper linkHeaderHelperFactory(
            Http.Request request,
            Repository repository) {

        long requestOffset =
                StringUtils.parseLong(
                        request.getQueryString(OFFSET_TAG))
                        .orElse(repository.getLastId());

        int requestLimit =
                StringUtils.parseInt(
                        request.getQueryString(LIMIT_TAG))
                        .orElse(DEFAULT_LIMIT);

        long nextOffset =
                getNextOffset(
                        repository,
                        requestOffset,
                        requestLimit);

        return new LinkHeaderHelper(
                request.secure(),
                request.host(),
                request.path(),
                nextOffset,
                requestOffset,
                requestLimit);
    }

    @SuppressWarnings("unchecked")
    private static long getNextOffset(
            Repository repository,
            long requestOffset,
            int requestLimit) {

        List<ModelEntity> result =
                repository.select(
                        requestOffset,
                        requestLimit,
                        CarsDao.OrderBy.DESC);

        if (result.isEmpty()) {
            return 0;
        } else {
            return result.get(result.size() - 1).getId() - 1;
        }
    }
}
