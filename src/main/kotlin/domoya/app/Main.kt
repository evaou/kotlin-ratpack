package domoya.app

import co.there4.hexagon.web.*

fun main(args: Array<String>) {
    get("/hello/{name}") { ok("Hello ${request["name"]}!") }
    run()
}