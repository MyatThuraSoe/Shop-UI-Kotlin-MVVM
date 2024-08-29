import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mtbazaar.R
import com.example.mtbazaar.databinding.ViewholderSizeBinding

class SizeAdapter(private val items: List<String>) :
    RecyclerView.Adapter<SizeAdapter.ViewHolder>() {

    private var selectedPosition = -1

    class ViewHolder(val binding: ViewholderSizeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderSizeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.sizeTxt.text = items[position]

        holder.binding.root.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = holder.adapterPosition
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }

        val context = holder.itemView.context
        if (selectedPosition == position) {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.grey_bg_selected)
            holder.binding.sizeTxt.setTextColor(ContextCompat.getColor(context, R.color.purple))
        } else {
            holder.binding.sizeLayout.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.sizeTxt.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
