package domoya.app

import ratpack.server.RatpackServer
import ratpack.http.MutableHeaders

fun main(args: Array<String>) {
    RatpackServer.start { serverSpec ->
        serverSpec
            .handlers { chain -> chain
                    .get { ctx ->
                        val headers: MutableHeaders = ctx.response.headers
                        headers.set("Access-Control-Allow-Origin", "*")
                        headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept")
                        ctx.response.send()
                    }
            }
    }
}