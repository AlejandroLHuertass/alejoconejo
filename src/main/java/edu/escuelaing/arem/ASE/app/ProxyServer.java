package edu.escuelaing.arem.ASE.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class ProxyServer {

    private static String[] urlServices = { "", "" };
    private static int service = 0;

    public static void main(String[] args) {

        staticFiles.location("/public");
        port(getPort());
        urlServices[0] = args[0];
        urlServices[1] = args[1];

        get("/factores", (req, res) -> {
            res.type("Application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            System.out.println(urlServices[0]);
            System.err.println(HttpConnectionExample.main(urlToUse() + "/factores?value=" + n));
            return HttpConnectionExample.main(urlServices[0] + "/factores?value=" + n);
        });

        get("/primos", (req, res) -> {
            res.type("Application/json");
            int n = Integer.parseInt(req.queryParams("value"));
            System.out.println(urlServices[0]);
            System.err.println(HttpConnectionExample.main(urlToUse() + "/primos?value=" + n));
            return HttpConnectionExample.main(urlServices[0] + "/primos?value=" + n);
        });
    }

    private static String urlToUse() {
        String domain = urlServices[service];
        if (service == 0) {
            service = 1;
        } else if (service == 1) {
            service = 0;
        }
        return domain;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
