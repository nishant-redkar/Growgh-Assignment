package com.example.growghassignment.Shorts

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.growghassignment.R

class ShortsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_shorts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager: ViewPager2 = view.findViewById(R.id.viewPager)
        val videoItemList = mutableListOf<Model>()

        videoItemList.add(
            Model(
                "https://firebasestorage.googleapis.com/v0/b/new-home-app.appspot.com/o/3%20Projects%20For%20Your%20Android%20Portfolio.mkv?alt=media&token=4dcb7fc4-162f-4286-9bab-e727211b6e6e",
                "@PhilippLackner",
                "\n\n3 Projects For Your Android Portfolio",
                "https://yt3.googleusercontent.com/mhup7lzHh_c9b55z0edX65ReN9iJmTF2JU7vMGER9LTOora-NnXtvZdtn_vJmTvW6-y97z0Y=s900-c-k-c0x00ffffff-no-rj",
                "https://yt3.googleusercontent.com/mhup7lzHh_c9b55z0edX65ReN9iJmTF2JU7vMGER9LTOora-NnXtvZdtn_vJmTvW6-y97z0Y=s900-c-k-c0x00ffffff-no-rj"
            )
        )

        videoItemList.add(
            Model(
                "https://firebasestorage.googleapis.com/v0/b/new-home-app.appspot.com/o/Android%20Dev%20Expectations%20VS.%20Reality.mkv?alt=media&token=f12afc97-e1ce-4337-8fd1-8dd967818e2d",
                "@PhilippLackner",
                "\n\nAndroid Dev Expectations VS. Reality",
                "https://yt3.googleusercontent.com/mhup7lzHh_c9b55z0edX65ReN9iJmTF2JU7vMGER9LTOora-NnXtvZdtn_vJmTvW6-y97z0Y=s900-c-k-c0x00ffffff-no-rj",
                "https://yt3.googleusercontent.com/mhup7lzHh_c9b55z0edX65ReN9iJmTF2JU7vMGER9LTOora-NnXtvZdtn_vJmTvW6-y97z0Y=s900-c-k-c0x00ffffff-no-rj"
            )
        )

        videoItemList.add(
            Model(
                "https://firebasestorage.googleapis.com/v0/b/new-home-app.appspot.com/o/Complete%20Mobile%20App%20Development%20Roadmap%20%F0%9F%A4%AF%20%23alisolanki%20%23shorts.mkv?alt=media&token=faf50178-b5d2-40e6-8303-163ed0312b92",
                "@AliSolanki",
                "\n\nComplete Mobile App Development Roadmap \uD83E\uDD2F #alisolanki #shorts",
                "https://yt3.googleusercontent.com/k5dJRR6Mvb5SlxFLRIPl7xdE7uxwh-8xzhnPY21JmhVuOLYtQl3CpB3ZhXTx-SbGJ09qiqznpug=s900-c-k-c0x00ffffff-no-rj",
                "https://yt3.googleusercontent.com/k5dJRR6Mvb5SlxFLRIPl7xdE7uxwh-8xzhnPY21JmhVuOLYtQl3CpB3ZhXTx-SbGJ09qiqznpug=s900-c-k-c0x00ffffff-no-rj"
            )
        )

        videoItemList.add(
            Model(
                "https://firebasestorage.googleapis.com/v0/b/new-home-app.appspot.com/o/How%20to%20become%20an%20Android%20Developer%20%F0%9F%92%B0%20%F0%9F%92%BB.mkv?alt=media&token=05f2718e-9170-45b7-be6c-83ef5db2bcfc",
                "@HarnoorSinghOfficial",
                "\n\nHow to become an Android Developer \uD83D\uDCB0 \uD83D\uDCBB",
                "https://d112y698adiu2z.cloudfront.net/photos/production/user_photos/000/756/823/datas/xlarge.png",
                "https://d112y698adiu2z.cloudfront.net/photos/production/user_photos/000/756/823/datas/xlarge.png"
            )
        )

        videoItemList.add(
            Model(
                "https://firebasestorage.googleapis.com/v0/b/new-home-app.appspot.com/o/Java%20vs%20Kotlin%20for%20Android%20App%20Development%20-%20Mobile%20App%20Development%20-%20Programming%20-%20%40SCALER.mp4?alt=media&token=e23f6f5c-f3c1-4895-a35c-4950885b655f",
                "@SCALER",
                "\n\nJava vs Kotlin for Android App Development | Mobile App Development | Programming | @SCALER",
                "https://yt3.googleusercontent.com/Hf8YZvGY0M1lgK7B-QUp9T3LHOxG1C2tJtvj9yADczCheYYfpvuCcurtecvBpLUrbgBH509z=s900-c-k-c0x00ffffff-no-rj",
                "https://yt3.googleusercontent.com/Hf8YZvGY0M1lgK7B-QUp9T3LHOxG1C2tJtvj9yADczCheYYfpvuCcurtecvBpLUrbgBH509z=s900-c-k-c0x00ffffff-no-rj"
            )
        )

        viewPager.adapter = Adapter(videoItemList, requireContext())
    }
}