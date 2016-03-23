package it.polimi.diceH2020.launcher.model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Transient;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.polimi.diceH2020.SPACE4Cloud.shared.inputData.InstanceData;
import it.polimi.diceH2020.launcher.Settings;
import it.polimi.diceH2020.launcher.utility.Compressor;

@Entity
public class SimulationsOptManager extends SimulationsManager{	
	
	private Integer numIter;
	
	private String provider = "";
	
	private Integer gamma;
	
	@Transient
	private InstanceData inputData;

	
	public SimulationsOptManager(){
		super();
		Settings set = new Settings();
		this.numIter = set.getNumIterations();
		setType("Opt");
	}
	
	public void buildExperiments() {
		super.getExperimentsList().clear();
		for (int it = 1; it <= this.numIter; it++) {
			InteractiveExperiment experiment = new InteractiveExperiment();
			experiment.setIter(it);
			experiment.setInstanceName(getInstanceName());
			experiment.setSimulationsManager(this);
			experiment.setGamma(this.gamma);
			experiment.setProvider(this.provider);
			experiment.setSimType("Opt");
			super.getExperimentsList().add(experiment);
		}
	}

	public Integer getNumIter() {
		return numIter;
	}

	public void setNumIter(Integer numIter) {
		this.numIter = numIter;
	}

	public InstanceData getInputData() {
		return inputData;
	}

	public void setInputData(InstanceData inputData) {
		this.inputData = inputData;

		ObjectMapper mapper = new ObjectMapper();
		try {
			setInput(Compressor.compress(mapper.writeValueAsString(inputData)));
		} catch (IOException e) {
			setInput("Error");
		}
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public Integer getGamma() {
		return gamma;
	}

	public void setGamma(Integer gamma) {
		this.gamma = gamma;
	}

}