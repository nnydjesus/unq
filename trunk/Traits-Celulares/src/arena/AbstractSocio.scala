package arena;


import java.util.Arrays
import org.uqbar.arena.bindings.DateAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.{Button, Label, Panel, Selector, TextBox}
import org.uqbar.arena.windows.{Dialog, WindowOwner}
import org.uqbar.commons.model.Home
import tadp.blocbaster.daos.Videoclub
import tadp.blocbaster.entidades.{Ciudad, Socio}


abstract class AbstractSocio(owner:WindowOwner, model:Socio) extends Dialog[Socio](owner, model) {
  
  var home:Home[Socio]= Videoclub.getInstance().getHome( classOf[Socio]);
  
	override def addActions(container:Panel)= {
		var button = new Button(container)  with AsDefaultButton with DisableOnErrorButton ;
		
		button.setCaption("Aceptar")
			  .onClick(new Function(this.accept));
//			.onClick(new MessageSend(this, "accept"));
//		.onClick(new Function(() => println("Mira como te meneo")));

		var button2 = new Button(container) //
		button2.setCaption("Cancelar")
			   .onClick(new Function(this.cancel));
	}
	

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
		
		// combo al enum de estado
//		new Label(form).setText("Estado");
//		new Selector(form).setContents(Arrays.asList(Socio.Estado.values()), "nombre").bindValueToProperty("estado");
//		
		new Label(form).setText("Ciudad");
		new Selector(form).setContents(Videoclub.getInstance().getHome(classOf[Ciudad]).allInstances(), "nombre")
	}
	

	def getHome() = this.home
	
	override def executeTask() = getHome().create(getModel())

}