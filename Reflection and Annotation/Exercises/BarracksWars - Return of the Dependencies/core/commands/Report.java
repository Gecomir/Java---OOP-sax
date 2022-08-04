package ReflectionAndAnnotation.barracksWarsDependencies.core.commands;

import ReflectionAndAnnotation.barracksWarsDependencies.annotations.Inject;
import ReflectionAndAnnotation.barracksWarsDependencies.interfaces.Repository;

public class Report extends Command {
    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
