package traits

import concept.Mobile;

trait Message extends Mobile{
  
	def send(aNumber:Int, message:String){
		println("Mandando el mensaje: " + message + " al numero: "+ aNumber + " desde: " + number)
	}

}