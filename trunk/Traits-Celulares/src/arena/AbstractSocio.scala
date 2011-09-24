package arena;


import arena.traits.{ButtonAcept,ButtonCancel}
import arena.modificado.MyDialog
import java.util.Arrays
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.{Button, Label, Panel, Selector, TextBox}
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.commons.model.Home
import videoclub.MyVideoclub
import tadp.blocbaster.daos.Videoclub
import tadp.blocbaster.entidades.{Ciudad, Socio}


abstract class AbstractSocio(owner:WindowOwner, model:Socio) extends MyDialog[Socio](owner, model) with ButtonAcept with ButtonCancel {
  
  var home:Home[Socio]= MyVideoclub.getInstance().getHome(classOf[Socio]);

	override def createMainTemplate(mainPanel:Panel )= {
		this.setTitle("ABM de Socios");
		super.createMainTemplate(mainPanel);
	}

	override def createFormPanel(mainPanel:Panel)=  {
		var form = new Panel(mainPanel);
		form.setLayout(new ColumnLayout(2));

		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty(Socio.NOMBRE);

		new Label(form).setText("Direccion");
		new TextBox(form).bindValueToProperty(Socio.DIRECCION);

		new Label(form).setText("Fecha de Ingreso");
		new TextBox(form).bindValueToProperty(Socio.FECHA_INGRESO).setAdapter(new DateAdapter());
		
		println("si borro esta linea no compila");
	}
	

	def getHome() = this.home

}