package wnderful.imgannotator.dataServiceImpl;

import wnderful.imgannotator.dao.daoService.*;
import wnderful.imgannotator.dataService.NormalDataService;
import wnderful.imgannotator.util.FileHelper;

public class NormalDataServiceImpl implements NormalDataService {
    private final MarksDaoService marksDaoService = new MarksDaoService();
    private final ProcessDaoService processDaoService = new ProcessDaoService();
    private final RequesterDaoService requesterDaoService = new RequesterDaoService();
    private final WorkerDaoService workerDaoService = new WorkerDaoService();
    private final TaskDaoService taskDaoService = new TaskDaoService();
    private final WorkDaoService workDaoService = new WorkDaoService();
    private final FileHelper fileHelper = new FileHelper();

    @Override
    public  boolean deleteAll() {
        marksDaoService.deleteAll();
        processDaoService.deleteAll();
        taskDaoService.deleteAll();
        workDaoService.deleteAll();
        workerDaoService.deleteAll();
        requesterDaoService.deleteAll();
        fileHelper.newFolder("data/work");
        fileHelper.newFolder("data/task");
        fileHelper.newFolder("data/process");
        fileHelper.newFolder("data/mark");
        fileHelper.newFolder("data/user/worker");
        fileHelper.newFolder("data/user/requester");
        return true;
    }
}
