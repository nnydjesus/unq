package traits

import concept.Mobile;

trait Call extends Mobile{
  
  def call(aNumber:Int){
    println(number + " Esta llamando al numero: " + aNumber)
  }

}