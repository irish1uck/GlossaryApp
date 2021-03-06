package com.example.glossaryapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.glossaryapp.R
import com.example.glossaryapp.activities.AddressActivity
import com.example.glossaryapp.database.DBHelper
import kotlinx.android.synthetic.main.fragment_user_address.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class UserAddressFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_user_address, container, false)
        init(view)
        return view
    }

    private fun init(view: View) {
        var dbHelper = DBHelper(context!!)
        var address = dbHelper.getAddress()
        view.text_view_fragment_address_pincode.text = address.pincode.toString()
        view.text_view_fragment_address_house_no.text = address.houseNo
        view.text_view_fragment_address_street_name.text = address.streetName
        view.text_view_fragment_address_city.text = address.city
        view.text_view_fragment_address_type.text = "Home"


        view.button_change_address.setOnClickListener{
            startActivity(Intent(context, AddressActivity::class.java))
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserAddressFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}