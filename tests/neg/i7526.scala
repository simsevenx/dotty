type Tr[-I, +O, +A] = I => (O, A)

trait NetApi with
  type Comp

trait NetDB extends NetApi with
  class Comp

trait NetHelper extends NetApi

def compQ(name: => String)
    : (given n: NetApi) => Tr[Nothing, n.Comp, n.Comp] = ???

object net extends NetDB with NetHelper
import net._
given n: NetApi = net

val q: Tr[Nothing, Comp, Comp] = compQ("???") // error Found: Tr[Nothing, ?1.Comp, ?1.Comp] Required: Tr[Nothing, net.Comp, net.Comp]