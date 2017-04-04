package domoya.app

import ratpack.handling.Context
import ratpack.handling.Handler
import ratpack.http.MutableHeaders

class CORSHandler: Handler {
    override fun handle(ctx: Context) {
        val headers: MutableHeaders = ctx.response.headers
        headers.set("Access-Control-Allow-Origin", "*")
        headers.set("Access-Control-Allow-Headers", "x-requested-with, origin, content-type, accept")

        ctx.next()
    }
}