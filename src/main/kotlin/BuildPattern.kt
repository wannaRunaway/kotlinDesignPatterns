//Build模式
class Product() {
    private lateinit var head: String
    private lateinit var body: String
    private lateinit var foot: String

    constructor(build: Build) : this() {
        this.head = build.head
        this.body = build.body
        this.foot = build.foot
    }

    override fun toString(): String {
        return ("Product: head $head body$body foot$foot")
    }


    class Build {
        lateinit var head: String
        lateinit var body: String
        lateinit var foot: String

        fun setHead(head: String): Build {
            this.head = head
            return this
        }

        fun setBody(body: String): Build {
            this.body = body
            return this
        }

        fun setFoot(foot: String): Build {
            this.foot = foot
            return this
        }

        fun build(): Product {
            return Product(this)
        }
    }
}

fun main() {
    var product = Product.Build()
        .setHead("yeah I'm head").setBody(" now is body").setFoot(" atlast foot").build()
    println(product.toString())
}