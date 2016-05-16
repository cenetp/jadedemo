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
public class AgentOne extends Agent {
	private static final long serialVersionUID = 1L;

	protected void setup() {
		 
		CyclicBehaviour loop; 
        loop = new CyclicBehaviour(this) {
			private static final long serialVersionUID = 1L;

			@Override
			public void action() {
				
				ACLMessage aclMsg = receive();
                
                if (aclMsg != null) {
                	// do something
                }
				block();
			}
        };
        addBehaviour(loop);
	}
}
