package arena;

import org.uqbar.arena.actions.MessageSend
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Home
import tadp.blocbaster.entidades.Socio

import org.uqbar.arena.windows.WindowOwner;

class NuevoSocio(owner:WindowOwner) extends AbstractSocio(owner, new Socio()) {
	
	override def executeTask() = {
		getHome().create(getModel());
	}
	
}
