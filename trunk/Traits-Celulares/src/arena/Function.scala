package arena

import org.uqbar.lacar.ui.model.Action;

 class Function(var method:()  => Unit) extends Action{

	override def execute() ={
	  method()
	}
	
}