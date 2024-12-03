package util;

import com.resend.*;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;

public class EmailSender {

    private final Resend resend;

    public EmailSender(String apiKey) {
        this.resend = new Resend(apiKey);
    }

    public void sendTestResults(String studentEmail, String studentName,
            int overallScore, String[] strengths, String[] improvements) {
        String htmlContent = String.format("""
            <!DOCTYPE html>
            <html>
            <head>
                <style>
                    body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }
                    .container { max-width: 600px; margin: 0 auto; padding: 20px; }
                    .header { background-color: #4CAF50; color: white; padding: 20px; text-align: center; }
                    .section { margin: 20px 0; padding: 15px; border-radius: 5px; }
                    .strengths { background-color: #E8F5E9; border-left: 5px solid #4CAF50; }
                    .improvements { background-color: #FFF3E0; border-left: 5px solid #FF9800; }
                    .score { font-size: 24px; font-weight: bold; color: #2196F3; text-align: center; }
                    ul { margin: 10px 0; padding-left: 20px; }
                    li { margin: 5px 0; }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="header">
                        <h1>Test Results for %s</h1>
                    </div>
                    
                    <p>Dear %s,</p>
                    
                    <p>We have completed the evaluation of your recent test. Here are your detailed results:</p>
                    
                    <div class="score">
                        Overall Score: %d%%
                    </div>
                    
                    <div class="section strengths">
                        <h2>🌟 Areas Where You Excelled:</h2>
                        <ul>
                            %s
                        </ul>
                    </div>
                    
                    <div class="section improvements">
                        <h2>💪 Areas for Improvement:</h2>
                        <ul>
                            %s
                        </ul>
                    </div>
                    
                    <p>Remember, learning is a journey, and these results are just stepping stones towards your academic growth. 
                    If you need any clarification or support, please don't hesitate to reach out to your teacher.</p>
                    
                    <p>Best regards,<br>Your Education Team</p>
                </div>
            </body>
            </html>
        """,
                studentName,
                studentName,
                overallScore,
                String.join("", java.util.Arrays.stream(strengths)
                        .map(s -> "<li>" + s + "</li>")
                        .toArray(String[]::new)),
                String.join("", java.util.Arrays.stream(improvements)
                        .map(s -> "<li>" + s + "</li>")
                        .toArray(String[]::new))
        );

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("onboarding@resend.dev")
                .to(studentEmail)
                .subject("Your Test Results")
                .html(htmlContent)
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println("Email sent successfully. ID: " + data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmailSender sender = new EmailSender("re_D7vnPUmY_QGs8r2NpeyzEC7XJnhuB2Ly9");

        // Example usage
        String[] strengths = {
            "Outstanding performance in problem-solving questions",
            "Excellent understanding of theoretical concepts",
            "Strong analytical skills demonstrated throughout the test"
        };

        String[] improvements = {
            "Review the fundamentals of Chapter 3",
            "Practice more time management during tests",
            "Focus on showing detailed work in calculations"
        };
        String name = "kaodk";

        sender.sendTestResults(
                "yuxuanxu2006@gmail.com",
                name,
                85,
                strengths,
                improvements
        );
    }
}
