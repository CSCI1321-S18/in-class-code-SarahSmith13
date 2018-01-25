package inClassMud

class Room (name: String, desc: String, exits: Array[Option[Int]], private var items: List[Int]){
  //if want to tell room vals when created put up there
  // other wise should be defined below
  //the getExit function should return the new exit from the room array 
  
  
  
}

/// should put map in here as a companion object
object Room { 
  val rooms = readRooms()
  
  
  def  readRooms(): Array[Room] = {
    // use an xml file not a txt file
    val xmlData = xml.XML.loadFile("NewFile.xml")
    (xmlData \ "room").map(n => {
      
      val name = (n \"@name").text
      val desc = (n \ "description").text
      val exits = (n \ "exits").text.split(" , ").map(_.toInt)
      val items = (n \ "item").map(in =>
        item((in \ "name").text, in.text)).toList
      new Room(name, desc, exits, items)
    })
    
  }
}
