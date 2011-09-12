package traits

import concept.Video

trait VideoPlayer {

  def play(video:Video){
    println("estoy reproduciendo el video: " + video.name);
  }

}