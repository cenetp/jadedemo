/**
 * 
 */
package de.unihildesheim.iis.jadedemo;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * @author Viktor Ayzenshtadt
 *
 */
public class AgentTwo extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
				
		// Define the behaviour
		CyclicBehaviour loop; 
        loop = new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				
				// Receive the incoming message
				ACLMessage aclMsg = receive();
                
				// Interpret the message
                if (aclMsg != null) {
                	System.out.println(myAgent.getLocalName() + "> Received message from: " + aclMsg.getSender());
                	System.out.println("Message content: " + aclMsg.getContent());
                }
                
				block(); // Stop the behaviour until next message is received
			}
        };
        addBehaviour(loop);
	}
}
