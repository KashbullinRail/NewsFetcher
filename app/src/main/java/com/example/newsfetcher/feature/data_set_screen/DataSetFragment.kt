package com.example.newsfetcher.feature.data_set_screen

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.newsfetcher.feature.search_setting_screen.presentation.REQUEST_DATE_FROM
import java.util.*


const val ARG_REQUEST_CODE = "ARG_REQUEST_CODE"
const val RESULT_DATE_KEY = "RESULT_DATE_KEY"
const val ARG_DATE = "ARG_DATE"


class DataSetFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dataListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            val date = (year.toString() + "-" + (month+1) + "-" + day.toString())
            Log.d("TAGG", "date = $date")
            val result = Bundle().apply {
                putSerializable(RESULT_DATE_KEY, date)
            }
            setFragmentResult(REQUEST_DATE_FROM, result)
        }

        val calendar = Calendar.getInstance()
        val initialYear = calendar.get(Calendar.YEAR)
        val initialMonth = calendar.get(Calendar.MONTH)
        val initialDay = calendar.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(
            requireContext(),
            dataListener,
            initialYear,
            initialMonth,
            initialDay
        )
    }

    companion object {
        fun newInstance(date: Date, requestKey: Int): DataSetFragment {
            val args = Bundle().apply {
                putSerializable(ARG_DATE, date)
                putSerializable(ARG_REQUEST_CODE,requestKey)
            }
            return DataSetFragment().apply {
                arguments = args
            }
        }
    }

}