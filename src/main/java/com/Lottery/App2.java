package com.Lottery;

public class App2 {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pipeline{");
        stringBuilder.append("\r");
        stringBuilder.append("agent any");
        stringBuilder.append("\r");
        stringBuilder.append("stages {");
        stringBuilder.append("\r");

        generate(stringBuilder);

        stringBuilder.append("\r");
        stringBuilder.append("}");
        stringBuilder.append("\r");
        stringBuilder.append("}");

        System.out.println(stringBuilder.toString());
    }

    private static void generate(StringBuilder stringBuilder){
        stringBuilder.append("stage('Sonar') {");
        stringBuilder.append("\r");
        stringBuilder.append("steps{");
        stringBuilder.append("\r");

        stringBuilder.append("build job: 'devops-test_sonar_test1', parameters: [text(name: 'image', value: '')]");

        stringBuilder.append("\r");
        stringBuilder.append("}");
        stringBuilder.append("\r");
        stringBuilder.append("}");
    }

}
