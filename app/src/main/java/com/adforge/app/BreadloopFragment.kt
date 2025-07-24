package com.adforge.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.adforge.app.R

class BreadloopFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.breadloop_placeholder, container, false)

        viewModel.breadloopState.observe(viewLifecycleOwner, Observer { state ->
            Toast.makeText(requireContext(), " State: \", Toast.LENGTH_SHORT).show()
        })

        viewModel.rewardCoinCount.observe(viewLifecycleOwner, Observer { coins ->
            Toast.makeText(requireContext(), " Coins: \", Toast.LENGTH_SHORT).show()
        })

        viewModel.raffleTriggered.observe(viewLifecycleOwner, Observer { triggered ->
            if (triggered) {
                Toast.makeText(requireContext(), " Raffle Ticket Entered!", Toast.LENGTH_SHORT).show()
                Log.i("AdForgeRaffle", " Ticket entered.")
            }
        })

        viewModel.raffleTicketCount.observe(viewLifecycleOwner, Observer { tickets ->
            Toast.makeText(requireContext(), " Total Tickets: \", Toast.LENGTH_SHORT).show()
        })

        viewModel.userReferralCode.observe(viewLifecycleOwner, Observer { code ->
            if (code.isNotEmpty()) {
                Toast.makeText(requireContext(), " Referral: \", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.crewCode.observe(viewLifecycleOwner, Observer { code ->
            if (code.isNotEmpty()) {
                Toast.makeText(requireContext(), " Crew Code: \", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.crewSize.observe(viewLifecycleOwner, Observer { size ->
            Toast.makeText(requireContext(), " Crew Size: \", Toast.LENGTH_SHORT).show()
        })

        viewModel.crewMultiplier.observe(viewLifecycleOwner, Observer { mult ->
            Toast.makeText(requireContext(), " Multiplier: x\", Toast.LENGTH_SHORT).show()
        })

        return view
    }
}
