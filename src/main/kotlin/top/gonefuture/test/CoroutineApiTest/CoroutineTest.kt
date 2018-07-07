package top.gonefuture.test.CoroutineApiTest

import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.buildSequence


fun main(args: Array<String>) {
    testYield()
}


fun main() = runBlocking {
    launch(Unconfined) {
        println("${Thread.currentThread().id} start")
        val res = async(CommonPool) {
            println("task ${Thread.currentThread().id} start")
            Thread.sleep(5000)
            "hello world"
        }
        val s = res.await()
        println("${Thread.currentThread().id} end and result is $s")
    }.join()

}


/*
 *  @author : 钱伟健 gonefuture@qq.com
 *  @version    : 2018/4/26 16:43.
 *  说明：
 */
/**
 *<pre> <pre>
 */

fun testYield() {
    val lazySeq = buildSequence {
        print("START ")
        for (i in 1..5) {
            yield(i)
            print("STEP ")
        }
        print("END")
    }
// 输出序列的前三个元素
    lazySeq.take(6).forEach { print("$it ") }
}



class  CoroutineTest {

}