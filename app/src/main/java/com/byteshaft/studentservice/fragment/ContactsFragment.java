package com.byteshaft.studentservice.fragment;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.byteshaft.studentservice.R;

import java.util.ArrayList;


public class ContactsFragment extends Fragment{
    private CursorAdapter mAdapter;
    private View mBaseView;
    private ListView listView;
    private ArrayList<String> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.contacts_fragment, container, false);
        listView = (ListView) mBaseView.findViewById(R.id.listView);
        arrayList = ReadPhoneContacts(getActivity());
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        return mBaseView;
    }


    public ArrayList<String> ReadPhoneContacts(Context cntx) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = cntx.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        Integer contactsCount = cursor.getCount(); // get how many contacts you have in your contacts list
        if (contactsCount > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0) {
                    //the below cursor will give you details for multiple contacts
                    Cursor pCursor = cntx.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    // continue till this cursor reaches to all phone numbers which are associated with a contact in the contact list
                    while (pCursor.moveToNext()) {
                        int phoneType = pCursor.getInt(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE));
                        //String isStarred 		= pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.STARRED));
                        String phoneNo = pCursor.getString(pCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        //you will get all phone numbers according to it's type as below switch case.
                        //Logs.e will print the phone number along with the name in DDMS. you can use these details where ever you want.
                        switch (phoneType) {
                            case ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE:
                                Log.e(contactName + ": TYPE_MOBILE", " " + phoneNo);
                                arrayList.add(phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_HOME:
                                Log.e(contactName + ": TYPE_HOME", " " + phoneNo);
                                arrayList.add(phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK:
                                Log.e(contactName + ": TYPE_WORK", " " + phoneNo);
                                arrayList.add(phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_WORK_MOBILE:
                                Log.e(contactName + ": TYPE_WORK_MOBILE", " " + phoneNo);
                                arrayList.add(phoneNo);
                                break;
                            case ContactsContract.CommonDataKinds.Phone.TYPE_OTHER:
                                Log.e(contactName + ": TYPE_OTHER", " " + phoneNo);
                                arrayList.add(phoneNo);
                                break;
                            default:
                                break;
                        }
                    }
                    pCursor.close();
                }
            }
            cursor.close();
        }

        return arrayList;
    }
}