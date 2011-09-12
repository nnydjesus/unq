package concept

import traits.Call;
import traits.Message;
import traits.MP3Player;
import traits.VideoPlayer;
import traits.GPS;
import traits.WIFI;


object Test extends Application{
  
    var cell1 = new Phone(1234) with MP3Player
    cell1.call(4321)
    cell1.send(4321, "hola 4321")
    cell1.play(new MP3("Dance of death"))
    
    println("\n ")

    var cell2 = new Phone(55555)with VideoPlayer with GPS
    cell2.call(1234)
    cell2.send(1234, "Todo Bien 1234")
    cell2.play(new Video("Titanic"))
    cell2.localizate()
    
    println("\n ")
    
    var cell3 = new Phone(55555) with MP3Player with VideoPlayer with WIFI 
    cell3.call(1234)
    cell3.play(new Video("Titanic"))
    cell3.play(new MP3("Dance of death"))
    cell3.connect("UNQ")
    
  

}