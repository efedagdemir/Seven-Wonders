package Server.ServerController;

import Server.ServerManager;

public class ServerControllerFacade {
    private static ServerControllerFacade serverControllerFacade = new ServerControllerFacade();

    private ServerManager serverManager;

    public static ServerControllerFacade getInstance(){
        return serverControllerFacade;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }

    public void setServerManager(ServerManager serverManager) {
        this.serverManager = serverManager;
    }
}
