package `in`.instea.dynamicphotoframe

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    var imageName = arrayOf("Virat", "Soumya Mam", "Malala", "Priyanka")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prevBtn = findViewById<ImageButton>(R.id.imgPrev)
        val nextBtn = findViewById<ImageButton>(R.id.imgNext)
        val name = findViewById<TextView>(R.id.tvName)

        prevBtn.setOnClickListener {

            // finding image id from the name of the image file in drawable
            val currentImageIdString = "pic$currentImage"
            val currentImageIdInt =
                this.resources.getIdentifier(currentImageIdString, "id", packageName)
            image = findViewById(currentImageIdInt)
            image.alpha = 0f

            currentImage = (4 + currentImage - 1) % 4
            val imageToShowString = "pic$currentImage"
            val imageToShowId =
                this.resources.getIdentifier(imageToShowString, "id", packageName)
            image = findViewById(imageToShowId)
            image.alpha = 1f
            name.text = imageName[currentImage]
        }

        nextBtn.setOnClickListener {

            val currentImageString = "pic$currentImage"
            val currentImageIdInt =
                this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(currentImageIdInt)
            image.alpha = 0f


            currentImage = (4 + currentImage + 1) % 4
            val imageToShowString = "pic$currentImage"
            val imageToShowIdInt =
                this.resources.getIdentifier(imageToShowString, "id", packageName)
            image = findViewById(imageToShowIdInt)
            image.alpha = 1f
            name.text = imageName[currentImage]


        }
    }
}