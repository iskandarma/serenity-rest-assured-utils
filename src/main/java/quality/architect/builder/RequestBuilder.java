package quality.architect.builder;

import net.serenitybdd.rest.SerenityRest;

public class RequestBuilder {

    private String method;
    private String url;
    private Object body;
    private String token;
    private Integer statusCode;
    private String jsonSchemaPath;

    public RequestBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    public RequestBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    public RequestBuilder setBody(Object body) {
        this.body = body;
        return this;
    }

    public RequestBuilder setToken(String  token) {
        this.token = token;
        return this;
    }

    public RequestBuilder setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public RequestBuilder setJsonSchemaPath(String jsonSchemaPath) {
        this.jsonSchemaPath = jsonSchemaPath;
        return this;
    }

    /**
     *
     * @return akan memanggil Request class dan menjalankan constructor
     */
    public Request sendIt(){
        return new Request(method, url, body, token, statusCode, jsonSchemaPath);
    }


    /**
     * Method untuk mengambil nilai dari response
     * @param resPath Parameter ini diisi dengan nilai field, path, atau key dari response JSON yang akan diambil nilainya
     * @return Hasilnya akan berupa string
     */
    public String getResponse(String resPath) {
        return SerenityRest
                .then()
                .extract()
                .path(resPath);
    }

}
