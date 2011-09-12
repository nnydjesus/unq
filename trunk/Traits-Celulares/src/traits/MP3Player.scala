package traits

import concept.MP3

trait MP3Player {
  
  def play(mp3:MP3){
    println("estoy reproduciendo el mp3: " + mp3.name);
  }

}