package com.byteshaft.studentservice.fragment;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.byteshaft.studentservice.AppGlobals;
import com.byteshaft.studentservice.R;


public class ScheduleFragment extends Fragment {
    private View mBaseView;

//    private TextView textViewContactName;
//    private ImageButton buttonSend;
//    private EditText editTextMessage;
//    private String contactName;
//
//    private String mContextUserTable;
//    String[] messages = new String[] {"testing" , "outgoing",  "outgoing"};
//
//    public ChatArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.chat_fragment, container, false);
        return mBaseView;
    }

//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        System.out.println(mBaseView == null);
//        textViewContactName = (TextView) mBaseView.findViewById(R.id.tv_contact_name_chat);
//        editTextMessage = (EditText) mBaseView.findViewById(R.id.et_chat);
//        buttonSend = (ImageButton) mBaseView.findViewById(R.id.button_chat_send);
//        buttonSend.setOnClickListener(this);
//        ListView bubbleList = (ListView) mBaseView.findViewById(R.id.lv_chat);
//
//        Intent intent = getActivity().getIntent();
//        contactName = intent.getStringExtra("CONTACT_NAME");
////        MessagesDatabase database = new MessagesDatabase(this);
//        mContextUserTable = intent.getStringExtra("user_table");
//        textViewContactName.setText(contactName);
//
//        try {
////            messages = database.getMessagesForContact(mContextUserTable);
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//            // Apparently no table exists.
//        }
//
//        adapter = new ChatArrayAdapter(AppGlobals.getContext(), R.layout.singlemessage_chat, messages);
//        bubbleList.setAdapter(adapter);
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    private class ChatArrayAdapter extends ArrayAdapter {
//
//        public ChatArrayAdapter(Context context, int resource,  String[] objects) {
//            super(context, resource, objects);
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ViewHolder holder;
//            if (convertView == null) {
//                LayoutInflater inflater = getActivity().getLayoutInflater();
//                convertView = inflater.inflate(R.layout.singlemessage_chat, parent, false);
//                holder = new ViewHolder();
//                holder.layout = (LinearLayout) convertView.findViewById(R.id.singleMessageContainer);
//                holder.title = (TextView) holder.layout.findViewById(R.id.singleMessage);
//                convertView.setTag(holder);
//            } else {
//                holder = (ViewHolder) convertView.getTag();
//            }
//            holder.title.setText(messages[0]);
//            return convertView;
//        }
//    }
//
//    static class ViewHolder {
//        public TextView title;
//        public LinearLayout layout;
//    }
}
