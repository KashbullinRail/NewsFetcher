package com.example.newsfetcher.feature.search_setting_screen.presentation.date_picker_screen

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import java.util.*


class DateFromSetFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val dataListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            val date = (year.toString() + "-" + (month+1) + "-" + day.toString())
            Log.d("TAGG", "dateListener = $date")
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
        fun newInstance(date: Date, requestKey: Int): DateFromSetFragment {
            val args = Bundle().apply {
                putSerializable(ARG_DATE, date)
                putSerializable(ARG_REQUEST_CODE, requestKey)
            }
            Log.d("TAGG", "dateSet = $args  $requestKey")
            return DateFromSetFragment().apply {
                arguments = args
            }
        }
    }

}