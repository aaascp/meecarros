package utils;

public class LinkHeaderHelper {

    private boolean isSecure;
    private String host;
    private String path;

    public LinkHeaderHelper(String host, String path, boolean isSecure) {
        this.host = host;
        this.path = path;
        this.isSecure = isSecure;
    }

    public String getLinkHeader(int size, int offset, int limit) {
        StringBuilder links = new StringBuilder();

        links.append(
                getLinkHeader(
                        0,
                        limit < size ? limit : size,
                        "first"));

        links.append(",");

        links.append(
                getLinkHeader(
                        size - (size % limit),
                        size % limit,
                        "last"));

        links.append(",");
        int nextOffset = offset + limit;
        if (nextOffset < size) {
            links.append(
                    getLinkHeader(
                            nextOffset,
                            (nextOffset + limit) < size ? limit : size - nextOffset,
                            "next"));
            links.append(",");
        }

        if (offset - limit >= 0) {
            links.append(
                    getLinkHeader(
                            offset - limit,
                            limit,
                            "prev"));
        }


        return links.toString();

    }

    private String getLinkHeader(int offset, int limit, String rel) {
        return String.format(
                "<http%s://%s%s?offset=%d&limit=%d>; rel=\"%s\"",
                isSecure ? "s" : "",
                host,
                path,
                offset,
                limit,
                rel
        );
    }
}
