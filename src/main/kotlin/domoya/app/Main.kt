package domoya.app

import ratpack.http.MutableHeaders
import ratpack.server.RatpackServer

fun main(args: Array<String>) {
    RatpackServer.start { server -> server
        .handlers { chain -> chain
            .get { ctx ->
                ctx.render("Hello World!\n")
            }
            .get("CORS") { ctx ->
                val headers: MutableHeaders = ctx.response.headers
                headers.set("Access-Control-Allow-Origin", "*")
                headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept")
                ctx.response.send()
            }
            .get(":name") { ctx ->
                ctx.render("Hello " + ctx.pathTokens["name"] + "!\n")
            }
        }
    }
}