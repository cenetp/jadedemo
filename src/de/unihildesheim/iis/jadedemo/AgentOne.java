/**
 * 
 */
package de.unihildesheim.iis.jadedemo;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Jade Agent template
 * @author Viktor Ayzenshtadt
 *
 */
public class AgentOne extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
		
		System.out.println("Hi. My name is " + getLocalName());
		
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
                	// Do something
                }
                
				block(); // Stop the behaviour until next message is received
			}
        };
        addBehaviour(loop);
	}
}
