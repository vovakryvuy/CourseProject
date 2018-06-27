package kryvyy.course.pllug.om.courseproject.ui.main.todo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kryvyy.course.pllug.om.courseproject.R;
import kryvyy.course.pllug.om.courseproject.databinding.FragmentLayoutBinding;
import kryvyy.course.pllug.om.courseproject.data.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.ui.main.main_interface.InterfacePresenter;

public class TodosFragment extends Fragment implements InterfacePresenter.Todos {
    public static final String AGRGUMENT_FOR_TODOS_USER_ID = "AGRGUMENT_FOR_TODOS_USER_ID";
    private TodosPresenter mTodosPresenter;
    private Integer mIdUser;
    private FragmentLayoutBinding binding;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdUser = getArguments().getInt(AGRGUMENT_FOR_TODOS_USER_ID);
        mTodosPresenter = new TodosPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_layout, container, false);
        initView();
        return binding.getRoot();
    }

    private void getTodos() {
        mTodosPresenter.getTodosByUser(mIdUser);
    }

    private void initView() {
        getTodos();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setAdapterTodos(RecyclerView.Adapter adapter) {
        binding.recycleView.setAdapter(adapter);
        binding.progressBar.setVisibility(View.GONE);
        binding.recycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void clickTodos(Todo todos) {

    }
}
