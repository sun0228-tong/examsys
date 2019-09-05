package com.qfedu.examsys.service.impl;

import com.qfedu.examsys.common.Testpaper;
import com.qfedu.examsys.dao.ExaminationDao;
import com.qfedu.examsys.entity.*;
import com.qfedu.examsys.examination.*;
import com.qfedu.examsys.service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired(required = false)
    private ExaminationDao examinationDao;

    @Override
    public Testpaper generate(Integer subjectId) {
//        Examination examination = new Examination();

        List<ChoiceQuestion> choiceQuestions = examinationDao.choiceQuestionList(subjectId,10);
        Choices choices = new Choices();
        List<Choice> choices1 = new ArrayList<>();
        for (ChoiceQuestion question : choiceQuestions) {
            Choice choice = new Choice();
            choice.setQuestionStem(question.getQuestion());
            choice.setScore(question.getScore());

            List<String> options = new ArrayList<>();
            options.add(question.getChoiceA());
            options.add(question.getChoiceB());
            options.add(question.getChoiceC());
            options.add(question.getChoiceD());
            choice.setOptions(options);

            List<String> answer = new ArrayList<>();
            answer.add(question.getRightAnswer());
            choice.setAnswer(answer);

            choices1.add(choice);
        }
        choices.setValues(choices1);


        List<MChoiceQuestion> mchoiceQuestions = examinationDao.mchoiceQuestionList(subjectId,10);
        Mchoices mchoices = new Mchoices();
        ArrayList<Mchoice> mchoices1 = new ArrayList<>();
        for (MChoiceQuestion question : mchoiceQuestions) {
            Mchoice mchoice = new Mchoice();
            mchoice.setQuestionStem(question.getQuestion());
            mchoice.setScore(question.getScore());

            ArrayList<String> options = new ArrayList<>();
            options.add(question.getChoiceA());
            options.add(question.getChoiceB());
            options.add(question.getChoiceC());
            options.add(question.getChoiceD());
            mchoice.setOptions(options);

            List<String> answer = new ArrayList<>();
//            mchoice.setAnswer(question.getRightAnswer().toCharArray());
            char[] array = question.getRightAnswer().toCharArray();
            for (char c : array) {
                answer.add(String.valueOf(c));
            }
            mchoice.setAnswer(answer);
            mchoices1.add(mchoice);
        }
        mchoices.setValues(mchoices1);


        List<JudgeQuestion> judgeQuestions = examinationDao.judgeQuestionList(subjectId,10);
        Judges judges = new Judges();
        List<Judge> judges1 = new ArrayList<>();
        for (JudgeQuestion question : judgeQuestions) {
            Judge judge = new Judge();
            judge.setQuestionStem(question.getQuestion());
            judge.setScore(question.getScore());

            List<String> options = new ArrayList<>();
            options.add("");
            judge.setOptions(options);

            List<String> answer = new ArrayList<>();
            answer.add(question.getRightAnswer().equals(1) ? "1" : "0");
            judge.setAnswer(answer);

            judges1.add(judge);
        }
        judges.setValues(judges1);


        List<ShortQuestion> shortQuestions = examinationDao.shortQuestionList(subjectId,5);
        Shorts shorts = new Shorts();
        List<Shorta> shorts1 = new ArrayList<>();
        for (ShortQuestion question : shortQuestions) {
            Shorta shorta = new Shorta();
            shorta.setQuestionStem(question.getQuestion());
            shorta.setScore(question.getScore());

            List<String> options = new ArrayList<>();
            options.add("");
            shorta.setOptions(options);

            List<String> answer = new ArrayList<>();
            answer.add("");
            shorta.setAnswer(answer);

            shorts1.add(shorta);
        }
        shorts.setValues(shorts1);

        List exam = new ArrayList();
        exam.add(choices);
        exam.add(mchoices);
        exam.add(judges);
        exam.add(shorts);

        return new Testpaper(exam);

        /*examination.setChoiceQuestions(choiceQuestions);
        examination.setMchoiceQuestions(mchoiceQuestions);
        examination.setJudgeQuestions(judgeQuestions);
        examination.setShortQuestions(shortQuestions);
        return examination;*/
    }
}
