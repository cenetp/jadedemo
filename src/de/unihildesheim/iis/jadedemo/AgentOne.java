package de.unihildesheim.iis.jadedemo;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.StaleProxyException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Jade Agent template
 *
 * @author Viktor Eisenstadt
 */
public class AgentOne extends Agent {
  private static final long serialVersionUID = 1L;

  protected void setup() {

    // Define the behaviour
    CyclicBehaviour loop = new CyclicBehaviour(this) {
      private static final long serialVersionUID = 1L;

      @Override
      public void action() {

        // Receive the incoming message
        ACLMessage aclMsg = receive();

        // Interpret the message
        if (aclMsg != null) {
          // do something
          System.out
              .println(myAgent.getLocalName() + "> Received message from: " + aclMsg.getSender());
          System.out.println("Received solution: " + aclMsg.getContent());
        }

        System.out.println("Enter the task:");
        // Read the task from command line
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in;
        try {
          in = reader.readLine();
          if (!in.equals("stop")) {
            System.out.println("Assigning task ...");
            ACLMessage newMsg = new ACLMessage(ACLMessage.REQUEST);
            newMsg.addReceiver(new AID("AgentTwo", AID.ISLOCALNAME));
            newMsg.setContent(in);
            send(newMsg);
          } else {
            System.out.println("Stopping ...");
            // Shut down main container
            Thread stopContainer = new Thread(() -> {
              try {
                getContainerController().kill();
              } catch (StaleProxyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            });
            stopContainer.start();
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        block(); // Stop the behaviour until next message is received
      }
    };
    addBehaviour(loop);
  }
}
