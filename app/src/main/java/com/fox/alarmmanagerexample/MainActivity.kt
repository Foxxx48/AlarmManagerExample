package com.fox.alarmmanagerexample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.alarmmanagerexample.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding
            get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, ALARM_REQUEST_CODE,
            intent, PendingIntent.FLAG_UPDATE_CURRENT)
//        val calendar = Calendar.getInstance().apply {
//            set(Calendar.HOUR_OF_DAY, newModel.hour)
//            set(Calendar.MINUTE, newModel.minute)
//
//
//                add(Calendar.DATE, 1)
//            }
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
//            calendar.timeInMillis,
            3000,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val SHARED_PREFERENCES_NAME = "time"
        private const val ALARM_KEY = "alarm"
        private const val ONOFF_KEY = "onOff"
        private const val ALARM_REQUEST_CODE = 1000

    }
}