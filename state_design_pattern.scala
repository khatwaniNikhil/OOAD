trait State {
	def changeState()
}

class Green(trafficSystem: TrafficSystem, reciever: Reciever) extends State {
	def changeState() =
	{
		reciever.off()
		trafficSystem.previousState=this;
		trafficSystem.currentState=trafficSystem.yellow
	}
}

class Red(trafficSystem: TrafficSystem, reciever: Reciever) extends State {
	def changeState() =
	{
		reciever.off()
		trafficSystem.previousState = this;
		trafficSystem.currentState = trafficSystem.yellow
	}
	
}


class Yellow(trafficSystem: TrafficSystem, reciever: Reciever) extends State {
	def changeState() =
	{
		reciever.off()
		if (trafficSystem.previousState.isInstanceOf[Green]) {
			trafficSystem.currentState = trafficSystem.red
		} else {
			trafficSystem.currentState = trafficSystem.green
		}
	}
}

Class Reciever {
	String light;
	def on();
	def off();
}

class TrafficSystem {
	var intialReciever:Reciever=new GreenReciever()
	var green:State=new Green(this,intialReciever)
	var red:State=new Red(this,new RedReciever)
	var yellow:State=new Yellow(this,new YellowReciever)
	
	var currentState:State=new Green(this,intialReciever)
	var previousState:State=new Green(this,intialReciever)
	
	def changeState()
	{
		currentState.changeState()
	}
	
}


object Test extends App{
	val trafficSystem:TrafficSystem=new TrafficSystem()
	while(true)
	{
		trafficSystem.displayState()
		if(trafficSystem.currentState.isInstanceOf[Yellow])
		{
			Thread.sleep(5000)
			trafficSystem.changeState()
		}
		else
		{
			Thread.sleep(30000)
			trafficSystem.changeState()
		}
	}
}
