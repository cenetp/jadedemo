package de.unihildesheim.iis.jadedemo;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

/**
 * @author Viktor Eisenstadt
 */
public class ContainerController {

  private static void startMainContainer() throws StaleProxyException {
    Runtime runtime = jade.core.Runtime.instance();
    runtime.setCloseVM(true);

    Profile profile = new ProfileImpl("127.0.0.1", 1099, null);
    profile.setParameter(Profile.GUI, "true");

    AgentContainer mainContainer = runtime.createMainContainer(profile);

    AgentController agentOne = mainContainer
        .createNewAgent("AgentOne", AgentOne.class.getName(), new Object[0]);
    agentOne.start();

    AgentController agentTwo = mainContainer
        .createNewAgent("AgentTwo", AgentTwo.class.getName(), new Object[0]);
    agentTwo.start();
  }

  public static void main(String[] args) {
    try {
      startMainContainer();
    } catch (StaleProxyException e) {
      System.out.println("Main container could not be started.");
      e.printStackTrace();
    }
  }
}
