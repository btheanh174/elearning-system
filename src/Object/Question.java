package Object;

public class Question {
	private int codeQuest;
	private int codeExam;
	private String Quest;
	private String QA;
	private String QB;
	private String QC;
	private String QD;
	private String Answer;

	public Question(int codeExam, String quest, String qA, String qB, String qC, String qD, String answer) {
		super();
		this.codeExam = codeExam;
		Quest = quest;
		QA = qA;
		QB = qB;
		QC = qC;
		QD = qD;
		Answer = answer;
	}

	public int getCodeQuest() {
		return codeQuest;
	}

	public void setCodeQuest(int codeQuest) {
		this.codeQuest = codeQuest;
	}

	public int getCodeExam() {
		return codeExam;
	}

	public void setCodeExam(int codeExam) {
		this.codeExam = codeExam;
	}

	public String getQuest() {
		return Quest;
	}

	public void setQuest(String quest) {
		Quest = quest;
	}

	public String getQA() {
		return QA;
	}

	public void setQA(String qA) {
		QA = qA;
	}

	public String getQB() {
		return QB;
	}

	public void setQB(String qB) {
		QB = qB;
	}

	public String getQC() {
		return QC;
	}

	public void setQC(String qC) {
		QC = qC;
	}

	public String getQD() {
		return QD;
	}

	public void setQD(String qD) {
		QD = qD;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

}
