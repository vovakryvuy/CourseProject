package kryvyy.course.pllug.om.courseproject.fragments;

import android.content.Context;
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
import kryvyy.course.pllug.om.courseproject.model_response.Todo;
import kryvyy.course.pllug.om.courseproject.presenter.InterfacePresenter;
import kryvyy.course.pllug.om.courseproject.presenter.TodosPresenter;

/**
 * Created by vovak on 16.06.2018.
 */

public class TodosFragment extends Fragment implements InterfacePresenter.Todos{
    public static final String AGRGUMENT_FOR_TODOS_USER_ID = "AGRGUMENT_FOR_TODOS_USER_ID";
    private TodosPresenter mTodosPresenter;
    private RecyclerView mRecyclerView;
    private Integer mIdUser;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mIdUser = getArguments().getInt(AGRGUMENT_FOR_TODOS_USER_ID);
        mTodosPresenter = new TodosPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fargment_layout, container, false);
        initView(view);
        getTodos();
        return view;
    }

    private void getTodos() {
        mTodosPresenter.getTodosByUser(mIdUser);
    }

    private void initView(View view) {
        mRecyclerView = view.findViewById(R.id.recycleView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setAdapterTodos(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void clickTodos(Todo todos) {

    }
}
