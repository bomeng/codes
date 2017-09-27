import java.util.Scanner

object Solution {
  def main(args: Array[String]) = {
    val sc = new Scanner (System.in)
    var a0 = sc.nextInt()
    var a1 = sc.nextInt()
    var a2 = sc.nextInt()
    var b0 = sc.nextInt()
    var b1 = sc.nextInt()
    var b2 = sc.nextInt()
    val alice = {
      if (a0 > b0) 1 else 0
    } + {
      if (a1 > b1) 1 else 0
    } + {
      if (a2 > b2) 1 else 0
    }
    val bob =  {
      if (a0 < b0) 1 else 0
    } + {
      if (a1 < b1) 1 else 0
    } + {
      if (a2 < b2) 1 else 0
    }
    println(alice + " " + bob)
  }
}
