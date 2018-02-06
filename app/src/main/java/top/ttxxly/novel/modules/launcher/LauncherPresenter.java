package top.ttxxly.novel.modules.launcher;

/**
 * Description:
 * Created by ttxxly on 2017-11-03 12:00
 * Updated by ttxxly on 2017-11-03 12:00
 * Email: ttxxly@gmail.com
 */
public class LauncherPresenter implements LauncherContract.Presenter{

    private LauncherContract.View mView;

    public LauncherPresenter(LauncherContract.View view) {

        mView = view;
    }

    @Override
    public void start() {
        mView.goHomeActivity();
    }

    @Override
    public void stop() {

    }
}
