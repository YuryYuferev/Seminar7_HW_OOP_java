package notebook.util;

import notebook.controller.Controller;
import notebook.controller.impl.NoteController;
import notebook.model.Note;
import notebook.model.repository.Operational;
import notebook.model.repository.impl.NoteRepository;
import notebook.util.connector.Connector;
import notebook.util.connector.impl.FileDBConnector;
import notebook.view.View;
import notebook.view.impl.ConsoleView;

public class AppManager {
    private Connector connector;
    private Operational<Note> repository;
    private Controller<Note> controller;
    private View<Note> view;

    public AppManager() {
        this.connector = new FileDBConnector();
        this.repository = new NoteRepository(connector);
        this.controller = new NoteController(repository);
        this.view = new ConsoleView(controller);
    }

    public void run() {
        connector.connect();
        view.run();
    }
}