package arena

import org.uqbar.arena.windows.Window
import org.uqbar.arena.Application
import org.uqbar.arena.windows.Dialog;
import tadp.blocbaster.entidades.Socio
import org.uqbar.commons.model.ObservableObject
import org.uqbar.commons.model.Search;


class ScalaApplication extends Application {
	
	override def createMainWindow():Window[Search[Socio]] =  new Buscador(this);
}