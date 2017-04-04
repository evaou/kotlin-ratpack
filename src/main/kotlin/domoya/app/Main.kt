package domoya.app

import ratpack.server.RatpackServer

fun main(args: Array<String>) {
    RatpackServer.start { server -> server
        .handlers { chain -> chain
            .all (
                CORSHandler()
            )
            .get { ctx ->
                ctx.render("Hello World!\n")
            }
            .get(":name") { ctx ->
                ctx.render("Hello " + ctx.pathTokens["name"] + "!\n")
            }
        }
    }
}