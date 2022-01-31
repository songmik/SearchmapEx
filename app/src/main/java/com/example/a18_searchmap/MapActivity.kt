package com.example.a18_searchmap

import android.location.LocationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a18_searchmap.databinding.ActivityMainBinding
import com.example.a18_searchmap.model.SearchResultEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class MapActivity: AppCompatActivity(), OnMapReadyCallback, CoroutineScope {

    companion object{
        const val SEARCH_RESULT_EXTRA_KEY = "SearchResult"
        const val PERMISSION_REQUEST_CODE = 1
        const val CAMERA_ZOOM_LEVEL = 17f
    }

    private lateinit var binding: ActivityMapBinding
    private lateinit var map: GoogleMap
    private lateinit var searchResult: SearchResultEntity
    private lateinit var locationManager: LocationManager
    private lateinit var myLocationListener: MyLocationListener

    private lateinit var job: Job

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private var currentSelectMarker: Marker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = Job()

        if(::searchResult.Initialized.not()){
            intent?.let {
                searchResult = intent.getParcelableExtra(SEARCH_RESULT_EXTRA_KEY) ?: throw Exception("데이터가 존재하지 않습니다.")
                setupGoogleMap()
            }
        }
        bindViews()
    }

    private fun bindViews() = with(binding){
        currentLocationButton.setOnClickListener {
            getMyLocation()
        }
    }

    private fun setupGoogleMap(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    onMapReady()


}